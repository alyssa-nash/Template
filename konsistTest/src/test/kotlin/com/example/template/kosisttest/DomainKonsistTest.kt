package com.example.template.kosisttest

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.withNameEndingWith
import com.lemonappdev.konsist.api.verify.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class DomainKonsistTest {
    @Test
    @DisplayName("Every UseCase class has single invoke method")
    fun givenUseCaseClass_thenAssertSingleInvokeMethod() {
        Konsist
            .scopeFromProject()
            .classes()
            .withNameEndingWith("UseCase")
            .assertTrue {
                val hasSingleInvokeOperatorMethod =
                    it.hasFunction { function ->
                        function.name == "invoke" && function.hasPublicOrDefaultModifier && function.hasOperatorModifier
                    }

                hasSingleInvokeOperatorMethod && it.countFunctions { item -> item.hasPublicOrDefaultModifier } == 1
            }
    }
}
