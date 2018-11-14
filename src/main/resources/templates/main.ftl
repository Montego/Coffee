<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>
    <@l.logout />
    <span><a href="/user">Список пользователей</a> </span>
</div>
<div>
    <form method="post" enctype="multipart/form-data">
        <input type="text" name="coffee_name" placeholder="Введите название кофе" />
        <input type="file" name="file"
        <input type="hidden" name="_csrf" value="${_csrf.token}" >
        <button type="submit">Добавить</button>
    </form>
</div>

<div>Список кофе</div>
<form method="get" action="/main">
    <input type="text" name="filter" value="${filter?ifExists}"/>
    <button type="submit">Найти</button>
</form>
    <#list coffees as coffee>
<div>
    <span>${coffee.name}</span>
    <strong>${coffee.authorName}</strong>
    <div>
        <#if coffee.filename??>
            <img src="/img/${coffee.filename}">
        </#if>
    </div>
</div>
    <#else>
Нет кофе с таким названием
    </#list>
</@c.page>