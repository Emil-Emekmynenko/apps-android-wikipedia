package org.wikipedia.homeworks.homework30

//CLI-утилиты Android SDK
//Утилита
//Назначение
//sdkmanager
//Установка компонентов Android SDK
//avdmanager
//Создание и управление виртуальными устройствами (AVD)
//emulator
//Запуск и управление эмуляторами
//adb
//Взаимодействие с работающим эмулятором или устройством
//
//
//
//sdkmanager: установка компонентов
//Обновить список доступных пакетов:
//sdkmanager --list
//
//Установить платформу и образ эмулятора:
//sdkmanager "platform-tools" "emulator" "system-images;android-33;google_apis;x86_64"
//
//avdmanager: создание и управление AVD
//Проверить доступные устройства и образы:
//avdmanager list device
//avdmanager list avd
//
//Создание AVD:
//avdmanager create avd \
//  --name testEmu \
//  --package "system-images;android-33;google_apis;x86_64" \
//  --device "pixel"
//
//emulator: запуск и управление эмулятором
//Запуск созданного ранее эмулятора
//emulator -avd testEmu \
//  -no-snapshot \
//  -wipe-data \
//  -port 5584 \
//  -skin 720x1280 \
//  -gpu host
//
//Часто используемые аргументы запуска
//
//Аргумент
//Описание
//-avd <имя>
//Указывает, какой AVD запускать
//-port <номер>
//Назначает порт (по умолчанию 5554). Значения должны быть чётными (5554, 5556 и т.д.)
//-wipe-data
//Полная очистка пользовательских данных AVD при запуске (эмулятор как "с нуля")
//-no-snapshot
//Не использовать снапшот (принудительно делает холодный старт)
//-no-boot-anim
//Отключить анимацию загрузки Android для ускорения старта
//-scale <коэф>
//Масштабирование окна (например, -scale 0.75)
//-memory <МБ>
//Количество оперативной памяти, выделенное эмулятору
//-gpu <режим>
//Режим графики: host, swiftshader_indirect, off
//-skin <размер>
//Размер экрана, например 480x800
//-no-window
//Запуск без GUI (важно для CI/CD)
//-verbose
//Подробный вывод в консоль (для отладки)
//
//
//Остановка эмулятора
//Найти имя или порт эмулятора:
//adb devices
//
//Пример вывода:
//List of devices attached
//emulator-5584   device
//
//Завершить эмулятор по порту:
//adb -s emulator-5584 emu kill