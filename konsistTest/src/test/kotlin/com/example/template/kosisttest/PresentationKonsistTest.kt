package com.example.template.kosisttest

import androidx.compose.ui.tooling.preview.Preview
import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.withAnnotationOf
import com.lemonappdev.konsist.api.verify.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PresentationKonsistTest {
    @Test
    @DisplayName("All JetPack Compose previews contain 'Preview' in method name")
    fun givenFunctionsWithPreviewAnnotation_thenAssertNameContainsPreview() {
        Konsist
            .scopeFromProject()
            .functions()
            .withAnnotationOf(Preview::class)
            .assertTrue {
                it.hasNameContaining("Preview")
            }
    }
}
