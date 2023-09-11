package com.github.casuallex.technodomruleset

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.RuleSet
import io.gitlab.arturbosch.detekt.api.RuleSetProvider

class DataModuleDetektSetProvider : RuleSetProvider {
    override val ruleSetId: String = "technodom"

    override fun instance(config: Config): RuleSet {
        return RuleSet(
            ruleSetId,
            listOf(
                DataPackageRule(config),
            ),
        )
    }
}
