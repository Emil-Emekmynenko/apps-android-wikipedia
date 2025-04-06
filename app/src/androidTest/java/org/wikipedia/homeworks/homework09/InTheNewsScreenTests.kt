package org.wikipedia.homeworks.homework09

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.InTheNewsItem
import org.wikipedia.homeworks.homework07.NewsCardViewItem
import org.wikipedia.homeworks.homework08.OnboardingScreen08
import org.wikipedia.main.MainActivity

class InTheNewsScreenTests: TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)
    @After
    fun tearDown(){
        device.files.pull(
            "/sdcard/Documents/allure-results", "app/build"
        )
    }

    @Test
    fun skipOnboarding(){
        run {
            step("Пропуск онбординг"){
                OnboardingScreen08.skipButton.click()
            }
            step("Отображение тулбара экрана ExploreScreen"){
                ExploreScreen.toolbarTitle.isVisible()
            }
            step("Проверка отображения экрана InTheNewsScreen"){
                ExploreScreen.items.childWith<InTheNewsItem> {
                    withDescendant {
                        withText("In the news")
                    }
                }.perform {
                    step("Пролистать до 2 слайда и нажать"){
                        newsCardViewRecycler.childAt<NewsCardViewItem>(2){
                            image.click()
                        }
                    }
                }
            }
            step("Нажать на статью"){
                DecorViewItem.cardRecycler.childAt<ListCardItem>(1){
                    imageCard.click()
                }
            }

            step("Проверка что элемент присутствует"){
                WikiArticleCard.image.isVisible()
            }
        }
    }
}