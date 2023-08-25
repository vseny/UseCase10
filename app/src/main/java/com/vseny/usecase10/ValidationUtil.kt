package com.vseny.usecase10

object ValidationUtil {

    private const val specialCharsList = """!"#$%&'()*+,-./:;<=>?@\[\\\]^_`{|}~"""

    private const val charsQuantityRegexPattern = "{0,}"

    private const val regexPattern =
        """^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[${specialCharsList}])(?=.*[^\s])[A-Za-z\d${specialCharsList}]${charsQuantityRegexPattern}$"""

    fun validate(input: String, maxLength: Int? = null): Boolean {
        val pattern = if (maxLength == null) {
            regexPattern
        } else {
            regexPattern.replace(charsQuantityRegexPattern, "{0,$maxLength}")
        }
        return Regex(pattern).matches(input)
    }
}
