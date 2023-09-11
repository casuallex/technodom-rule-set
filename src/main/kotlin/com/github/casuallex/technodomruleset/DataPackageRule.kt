package com.github.casuallex.technodomruleset

import io.gitlab.arturbosch.detekt.api.CodeSmell
import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.Debt
import io.gitlab.arturbosch.detekt.api.Entity
import io.gitlab.arturbosch.detekt.api.Issue
import io.gitlab.arturbosch.detekt.api.Rule
import io.gitlab.arturbosch.detekt.api.Severity
import io.gitlab.arturbosch.detekt.rules.hasAnnotation
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtPackageDirective

class DataPackageRule(config: Config) : Rule(config) {
    override val issue = Issue(
        javaClass.simpleName,
        Severity.Defect,
        "this kind of classes should be in data package",
        Debt.FIVE_MINS,
    )

    var currentPackageName: String? = null

//    override fun visitPackageDirective(directive: KtPackageDirective) {
//        currentPackageName = directive.qualifiedName
//    }

    override fun visitClass(klass: KtClass) {
        super.visitClass(klass)
//        if (klass.hasAnnotation("JsonClass")) {
        report(
            CodeSmell(
                issue,
                entity = Entity.from(klass),
                "@JsonClass анотация должна находиться в пакете kz.technodom.{MODULE_NAME}.data"
            )
        )
//        }
//        klass.annotationEntries.forEach {
//            if (it.text.startsWith("@JsonClass")) {
//                val packageTokens = currentPackageName?.split(".").orEmpty()
//                if (packageTokens.size != 5 || packageTokens[0] != "kz" || packageTokens[1] != "technodom" || packageTokens[3] != "data" || packageTokens[4] != "models") {
//
//                }
//            }
//        }
    }
}
