FROM openjdk:21-jdk-bullseye

LABEL version="1.0.2"

ENV DEBIAN_FRONTEND=noninteractive
ENV LANG='en_US.UTF-8'
ENV LANGUAGE='en_US:en'
ENV LC_ALL='en_US.UTF-8'

RUN apt-get update && \
    apt-get install --yes \
    xvfb lib32z1 lib32stdc++6 build-essential \
    libcurl4-openssl-dev libglu1-mesa libxi-dev libxmu-dev \
    libglu1-mesa-dev

RUN apt-get -qq update && \
    apt-get install -qqy --no-install-recommends \
    ca-certificates \
    bzip2 \
    curl \
    git-core \
    html2text \
    unzip \
    locales \
    rsync \
    openssh-server \
    iputils-ping \
    && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

# ----------------- Gradle -----------------
ENV GRADLE_HOME=/opt/gradle
ENV GRADLE_USER_HOME=${GRADLE_HOME}
ENV GRADLE_VERSION=8.11.1
ENV VERSION_SDK_TOOLS="13114758_latest"
ENV WHO="jenkins_agent"
ENV GRADLE_NAME="gradle-${GRADLE_VERSION}-bin"
ENV GRADLE_ZIP_NAME="${GRADLE_NAME}.zip"

# take it from jenkins log on line "Unzipping /home/jenkins/...." when gradle distributionUrl changes
ENV GRADLE_SPECIFIC_PATCH="${GRADLE_NAME}/kgsygamhjj3zf16yem2xgstz"

RUN set -o errexit -o nounset \
    && echo "Downloading Gradle" \
    && wget --no-verbose --output-document=${GRADLE_ZIP_NAME} "https://services.gradle.org/distributions/${GRADLE_ZIP_NAME}" \
    && echo "Installing Gradle" \
    && unzip "${GRADLE_ZIP_NAME}" \
    && mkdir -p "${GRADLE_HOME}/wrapper/dists/${GRADLE_SPECIFIC_PATCH}" \
    && mv "gradle-${GRADLE_VERSION}" "${GRADLE_HOME}/wrapper/dists/${GRADLE_SPECIFIC_PATCH}" \
    && mv "${GRADLE_ZIP_NAME}" "${GRADLE_HOME}/wrapper/dists/${GRADLE_SPECIFIC_PATCH}"

# ----------------- Android SDK -----------------
ENV ANDROID_HOME=/opt/android-sdk
# https://developer.android.com/studio/index.html#command-tools
ENV ANDROID_PLATFORM_VERSION=35
ENV ANDROID_BUILD_TOOLS_VERSION_PREV=34.0.0
ENV ANDROID_BUILD_TOOLS_VERSION=35.0.1
ENV ANDROID_SDK_URL=https://dl.google.com/android/repository/commandlinetools-linux-${VERSION_SDK_TOOLS}.zip
ENV ANDROID_SDK_FILE_NAME=android-sdk.zip

ENV PATH="${PATH}:${GRADLE_HOME}/:${GRADLE_HOME}/bin"
ENV PATH="${PATH}:${ANDROID_HOME}/tools/:${ANDROID_HOME}/tools/bin:${ANDROID_HOME}/platform-tools:${ANDROID_HOME}/platform-tools/bin:${ANDROID_HOME}/cmdline-tools/latest/bin"

RUN  echo "export ANDROID_SDK_ROOT=$ANDROID_HOME" | cat - ~/.bashrc >> temp && mv temp ~/.bashrc
# ----------------- Permissions -----------------
ENV HOME="/home/jenkins"
RUN groupadd -g 1000 -r jenkins && \
    groupadd -g 999 -r docker && \
    groupadd -g 994 -r dockerroot && \
    useradd --create-home -d "/home/jenkins" -u 1000 -r -g jenkins -G docker,dockerroot jenkins

# Update sdk and install components
# --package_file is broken https://issuetracker.google.com/issues/66465833
# empty file to mitigate warning
RUN wget -nc $ANDROID_SDK_URL -O $ANDROID_SDK_FILE_NAME && \
    mkdir -p $ANDROID_HOME && \
    unzip -q $ANDROID_SDK_FILE_NAME -d $ANDROID_HOME/cmdline-tools/ && \
    mv $ANDROID_HOME/cmdline-tools/cmdline-tools $ANDROID_HOME/cmdline-tools/latest && \
    rm $ANDROID_SDK_FILE_NAME && \
    mkdir $HOME/.android && \
    touch $HOME/.android/repositories.cfg && \
    yes | sdkmanager --licenses && \
    echo "y" | sdkmanager --verbose \
    "build-tools;$ANDROID_BUILD_TOOLS_VERSION_PREV" \
    "build-tools;$ANDROID_BUILD_TOOLS_VERSION" \
    "platform-tools" \
    "platforms;android-$ANDROID_PLATFORM_VERSION" && \
    sdkmanager --update && \
	mkdir $HOME/.ssh && \
	mkdir $HOME/wiki

COPY id_rsa.pub $HOME/.ssh/id_rsa.pub
COPY id_rsa $HOME/.ssh/id_rsa

RUN chown -R jenkins:jenkins $HOME && \
    chown -R jenkins:jenkins $ANDROID_HOME && \
    chmod -R o+rwX $GRADLE_HOME && \
	chmod 600 $HOME/.ssh/id_rsa && \
	chmod 600 $HOME/.ssh/id_rsa.pub


# switch to user jenkins
USER jenkins