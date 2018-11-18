<#import "parts/common.ftl" as c>

<@c.page>
<div class="userlist">
    <h1 class="userlist__title">Список пользователей</h1>
    <table class="userlist__table table">
        <thead>
            <tr>
                <th>Дата регистрации</th>
                <th>Имя пользователя</th>
                <th>Права пользователя</th>
                <th>Опции</th>
            </tr>
        </thead>
        <#list users as user>
            <tr>
                <td>
                    <#if user.creationDate??>
                        ${user.creationDate}
                    </#if></td>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><a href="/user/${user.id}">edit</a></td>
            </tr>
        </#list>
    </table>
</div>
</@c.page>