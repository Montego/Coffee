<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div class="login">
    <div>Add new user</div>
    ${message?ifExists}
    <@l.login "/registration" true/>
</div>
</@c.page>