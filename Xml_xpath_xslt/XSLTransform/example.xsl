<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet
    version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <xsl:for-each select="breakfast_menu/food">
            <p><xsl:value-of select="name" /></p>
            <ul>
                <li>Price: <xsl:value-of select="price" /></li>
                <li>Description: <xsl:value-of select="description" /></li>
                <li>Calories: <xsl:value-of select="calories" /></li>
            </ul>
        </xsl:for-each>
    </xsl:template>

</xsl:stylesheet>