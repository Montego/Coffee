<#macro login path isRegisterForm>

    <form class="login-2" action="${path}" method="post">
        <div class="login-2__row">
            <label class="login-2__label" for="username"> User Name: </label>
            <input type="text" name="username" id="username"/>
        </div>
        <div class="login-2__row">
            <label class="login-2__label" for="password"> Password: </label>
            <input type="password" name="password" id="password"/>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <#if !isRegisterForm>
            <a href="/registration">Add new user</a>
        </#if>
        <button class="btn btn-primary" type="submit"><#if isRegisterForm>Create<#else>Sign In</#if></button>
    </form>

</#macro>

<#macro logout>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button class="btn btn-primary" type="submit">Sign Out</button>
</form>
</#macro>