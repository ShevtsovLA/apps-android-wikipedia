package org.wikipedia.homeworks

import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.wikipedia.homeworks.homework08.ExploreScreenTests
import org.wikipedia.homeworks.homework08.OnboardingScreenTests
import org.wikipedia.homeworks.homework09.InTheNewsTest
import org.wikipedia.homeworks.homework10.OnboardingScreenUiTest
import org.wikipedia.homeworks.homework13.WebViewTest

@RunWith(Suite::class)
@Suite.SuiteClasses(
    OnboardingScreenTests::class,
    ExploreScreenTests::class,
    InTheNewsTest::class,
    OnboardingScreenUiTest::class,
   //WebViewTest::class,
)

class TestSuite
