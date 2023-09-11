package com.github.casuallex.technodomruleset

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.rules.KotlinCoreEnvironmentTest
import io.gitlab.arturbosch.detekt.test.compileAndLintWithContext
import io.kotest.matchers.collections.shouldHaveSize
import org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreEnvironment
import org.junit.jupiter.api.Test

@KotlinCoreEnvironmentTest
internal class MoshiPackageTest(private val env: KotlinCoreEnvironment) {

    @Test
    fun `reports inner classes`() {
        val code = """
            package kz.technodom.auth.domain.models

            @JsonClass(generateAdapter = true)
            class AuthResponse()

        """
        val findings = DataPackageRule(Config.empty).compileAndLintWithContext(env, code)
        findings shouldHaveSize 1
    }
    @Test
    fun `not report package`() {
        val code = """
            package kz.technodom.auth.data.models

            @JsonClass(generateAdapter = true)
            class AuthResponse()

        """
        val findings = DataPackageRule(Config.empty).compileAndLintWithContext(env, code)
        findings shouldHaveSize 0
    }
}
