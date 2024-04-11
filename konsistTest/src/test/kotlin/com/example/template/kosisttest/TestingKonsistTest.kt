package com.example.template.kosisttest

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.declarations
import com.lemonappdev.konsist.api.ext.list.functions
import com.lemonappdev.konsist.api.ext.list.withNameEndingWith
import com.lemonappdev.konsist.api.ext.list.withoutAnnotationOf
import com.lemonappdev.konsist.api.provider.KoAnnotationProvider
import com.lemonappdev.konsist.api.provider.modifier.KoVisibilityModifierProvider
import com.lemonappdev.konsist.api.verify.assertFalse
import com.lemonappdev.konsist.api.verify.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class TestingKonsistTest {
    @Test
    @DisplayName("Don't use JUnit4 Test annotation")
    fun givenTestFunction_thenAssertNotJUnit4TestAnnotation() {
        Konsist.scopeFromProject()
            .classes()
            .functions()
            .assertFalse { it.hasAnnotationWithName("org.junit.Test") }
    }

    @Test
    @DisplayName("Test classes should have all members private besides tests")
    fun givenTestClass_thenAssertAllNonTestMembersArePrivate() {
        Konsist
            .scopeFromTest()
            .classes()
            .declarations()
            .filterIsInstance<KoAnnotationProvider>()
            .withoutAnnotationOf(Test::class)
            .filterIsInstance<KoVisibilityModifierProvider>()
            .assertTrue { it.hasPrivateModifier }
    }

    @Test
    @DisplayName("Every UseCase class has test")
    fun givenUseCaseClass_thenAssertHasTestClass() {
        Konsist
            .scopeFromProduction()
            .classes()
            .withNameEndingWith("UseCase")
            .assertTrue { it.hasTestClasses() }
    }

    @Test
    @DisplayName("Every ViewModel class has test")
    fun givenViewModelClass_thenAssertHasTestClass() {
        Konsist
            .scopeFromProduction()
            .classes()
            .withNameEndingWith("ViewModel")
            .assertTrue { it.hasTestClasses() }
    }
}
