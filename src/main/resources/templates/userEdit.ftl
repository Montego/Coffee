<#import "parts/common.ftl" as c>

<@c.page>
    Редактиование пользователя

<form action="/user" method="post">
    <input type="text" value="${user.id}" name="userId">
    <input type="hidden" name="_csrf" value="${_csrf.token}" >
    <button type="submit">Сохранить</button>
</form>
</@c.page>