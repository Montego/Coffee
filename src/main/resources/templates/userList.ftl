<#import "parts/common.ftl" as c>

<@c.page>
    Список пользователей
<table>
    <thead>
    <tr>
        <th>Имя пользователня</th>
        <th>Права пользователня</th>
        <th></th>
    </tr>
    </thead>
    <#list users as user>
        <tr>
            <td>${user.username}</td>
            <td><#list user.roles as role>${role}<#sep>, </#list></td>
            <td><a href="/user/${user.id}">edit</a></td>
        </tr>
    </#list>
</table>
</@c.page>