<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet
    version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <p>Expensive Waffles</p>
        <ul>
            <xsl:for-each select="breakfast_menu/food">
                <xsl:if test="price &gt; 7.0">
                    <li>
                        <p><xsl:value-of select="name" /></p>
                        <ul>
                            <li>Price: <xsl:value-of select="price" /></li>
                            <li>Description: <xsl:value-of select="description" /></li>
                            <li>Calories: <xsl:value-of select="calories" /></li>
                        </ul>
                    </li>
                </xsl:if>
            </xsl:for-each>
        </ul>
        <p>Waffles with an extra tag</p>
        <xsl:for-each select="breakfast_menu/food">
            <xsl:sort select="price" />
            <ul>
                <xsl:choose>
                    <xsl:when test="price &gt; 7.0">
                        <li>Category: Expensive</li>
                    </xsl:when>
                    <xsl:otherwise>
                        <li>Category: Cheap</li>
                    </xsl:otherwise>
                </xsl:choose>
                <li>Price: <xsl:value-of select="price" /></li>
                <li>Description: <xsl:value-of select="description" /></li>
                <li>Calories: <xsl:value-of select="calories" /></li>
            </ul>
        </xsl:for-each>
    </xsl:template>

</xsl:stylesheet>