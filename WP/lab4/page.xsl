<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >

<xsl:template match="/">
  <html>
  <head>
    <link rel="stylesheet" type="text/css" href="style.css" />
  </head>
  
  <body>
  <h1>Bibliography</h1>
    <h2>Articles</h2>
    <table>
      <tr>
        <th >Author</th>
        <th>Title</th>
        <th>Editor</th>
        <th>Number of pages</th>
        <th>Publication year</th>
      </tr>
      <xsl:for-each select="bibliography/articles/article">
      <xsl:sort select="title"/>
      <tr class="article">
        <td><xsl:value-of select="author"/></td>
        <td><xsl:value-of select="title"/></td>
        <td><xsl:value-of select="editor"/></td>
        <td><xsl:value-of select="nb-pages"/></td>
        <td><xsl:value-of select="pub-year"/></td>
      </tr>
      </xsl:for-each>
    </table>

    <h2>Books</h2>
    <table>
      <tr>
        <th>Author</th>
        <th>Title</th>
        <th>Editor</th>
        <th>Number of pages</th>
        <th>Publication year</th>
      </tr>
      <xsl:for-each select="bibliography/books/book">
      <xsl:sort select="title"/>
      <tr class="article">
        <td><xsl:value-of select="author"/></td>
        <td><xsl:value-of select="title"/></td>
        <td><xsl:value-of select="editor"/></td>
        <td><xsl:value-of select="nb-pages"/></td>
        <td><xsl:value-of select="pub-year"/></td>
      </tr>
      </xsl:for-each>
    </table>

    <h2>Reports</h2>
    <table>
      <tr>
        <th>Author</th>
        <th>Title</th>
        <th>Editor</th>
        <th>Number of pages</th>
        <th>Publication year</th>
      </tr>
      <xsl:for-each select="bibliography/reports/report">
      <xsl:sort select="title"/>
      <tr class="article">
        <td><xsl:value-of select="author"/></td>
        <td><xsl:value-of select="title"/></td>
        <td><xsl:value-of select="editor"/></td>
        <td><xsl:value-of select="nb-pages"/></td>
        <td><xsl:value-of select="pub-year"/></td>
      </tr>
      </xsl:for-each>
    </table>


    <h2>Presentations</h2>
    <table>
      <tr>
        <th>Author</th>
        <th>Title</th>
        <th>Editor</th>
        <th>Number of pages</th>
        <th>Publication year</th>
      </tr>
      <xsl:for-each select="bibliography/presentations/presentation">
      <xsl:sort select="title"/>
      <tr class="article">
        <td><xsl:value-of select="author"/></td>
        <td><xsl:value-of select="title"/></td>
        <td><xsl:value-of select="editor"/></td>
        <td><xsl:value-of select="nb-pages"/></td>
        <td><xsl:value-of select="pub-year"/></td>
      </tr>
      </xsl:for-each>
    </table>

    <h2>Web-links</h2>
    <table>
      <tr>
        <th>Author</th>
        <th>Title</th>
        <th>Editor</th>
        <th>Number of pages</th>
        <th>Publication year</th>
      </tr>
      <xsl:for-each select="bibliography/web-links/web-link">
      <xsl:sort select="title"/>
      <tr class="article">
        <td><xsl:value-of select="author"/></td>
        <td><xsl:value-of select="title"/></td>
        <td><xsl:value-of select="editor"/></td>
        <td><xsl:value-of select="nb-pages"/></td>
        <td><xsl:value-of select="pub-year"/></td>
      </tr>
      </xsl:for-each>
    </table>

    <h2>Software packages</h2>
    <table>
      <tr>
        <th>Author</th>
        <th>Title</th>
        <th>Editor</th>
        <th>Number of pages</th>
        <th>Publication year</th>
      </tr>
      <xsl:for-each select="bibliography/software-packages/software-package">
      <xsl:sort select="title"/>
      <tr class="article">
        <td><xsl:value-of select="author"/></td>
        <td><xsl:value-of select="title"/></td>
        <td><xsl:value-of select="editor"/></td>
        <td><xsl:value-of select="nb-pages"/></td>
        <td><xsl:value-of select="pub-year"/></td>
      </tr>
      </xsl:for-each>
    </table>

  </body>
  </html>
</xsl:template>
</xsl:stylesheet>