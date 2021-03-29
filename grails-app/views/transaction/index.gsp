<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'transaction.label', default: 'Transaction')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
    <content tag="nav">
        <li class="navItem">
            <a href="/" class="navItem-toggle" role="button" aria-haspopup="true" aria-expanded="false">Home <span class="caret"></span></a>
        </li>
        <li class="navItem">
            <a href="/item/index" class="navItem-toggle" role="button" aria-haspopup="true" aria-expanded="false">Item <span class="caret"></span></a>
        </li>
        <li class="navItem">
            <a href="/transaction/index" class="navItem-toggle" role="button" aria-haspopup="true" aria-expanded="false">Transaction <span class="caret"></span></a>
        </li>
    </content>
        <a href="#list-transaction" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-transaction" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${transactionList}" />

            <div class="pagination">
                <g:paginate total="${transactionCount ?: 0}" />
            </div>
        </div>
    </body>
</html>