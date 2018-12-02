<#import "parts/common.ftl" as c>

<@c.page>

<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/main" class="form-inline" >
            <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search coffee"/>
            <button  type="submit" class="btn btn-primary ml-2">Search</button>
        </form>
    </div>
</div>

<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Add new Coffee
</a>

<div class="collapse" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                    <input type="text" name="coffee_name" placeholder="Coffee name" />
            </div>
            <div class="form-group">
                <div class="custom-file">
                    <input type="file" name="file" id="customFile">
                    <label class="custom-file-label" for="customFile">Choose file</label>
                </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Add coffee</button>
            </div>
        </form>
    </div>
</div>

<div class="coffeelist">
    <h1 class="coffeelist__title">Список кофе</h1>
    <table class="coffeelist__table table">
        <thead>
        <tr>
            <th>Дата изменения</th>
            <th>Автор</th>
            <th>Название кофе</th>
            <th>Изображение</th>
            <th>Опции</th>
        </tr>
        </thead>
        <#list coffees as coffee>
            <tr>
                <td>
                    <#if coffee.creationDate??>
                        ${coffee.creationDate}
                     </#if>
                </td>
                <td>${coffee.authorName}</td>
                <td>${coffee.name}</td>
                <td>
                    <div class="coffeelist__table__img">
                        <#if coffee.filename??>
                            <img src="/img/${coffee.filename}" class="card-img-top">
                        </#if>
                    </div>
                </td>
                <td>
                    <a href="/coffee/${coffee.id}">edit</a>
                    <#--<button type="submit" class=".js-button">delete</button>-->
                    <form method="POST">
                        <input type="hidden" name="coffee_id" value="${coffee.id}" />
                        <button type="submit" class=".js-button">delete</button>
                    </form>
                    <#--<a href="/coffee/${coffee.id}">delete</a>-->
                </td>
            </tr>
        <#else>
Sorry, no coffee with such name
        </#list>
    </table>
</div>

<#--<div>Coffee List</div>-->
<#--<div class="card-columns">-->
    <#--<#list coffees as coffee>-->
        <#--<div class="card my-3">-->
       <#--<#if coffee.filename??>-->
                    <#--<img src="/img/${coffee.filename}" class="card-img-top">-->
       <#--</#if>-->
            <#--<div>-->
                <#--<span>${coffee.name}</span>-->
            <#--</div>-->
            <#--<div class="card-footer text-muted">-->
                <#--${coffee.authorName}-->
            <#--</div>-->
        <#--</div>-->
    <#--&lt;#&ndash;<button class="btn btn-primary" type="submit">Delete</button>&ndash;&gt;-->
    <#--<#else>-->
<#--Sorry, no coffee with such name-->
    <#--</#list>-->
</@c.page>

