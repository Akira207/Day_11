<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<style>
    *{
        margin: 0;
        padding: 0;
    }
    nav{
        background-color: #3578E5;
    }
    nav ul{
        display: flex;
        justify-content: flex-start;
        align-items: center;
        list-style: none;
    }
    nav ul li a {
        color: #fff;
        display: block;
        padding: 1rem;
        text-decoration: none;
    }
    nav ul li:first-child a{
        padding-left: 0 !important;
    }
    nav ul li a:hover{
        color: yellow;
    }
</style>
<nav>
    <ul class="container">
        <li>
            <a href="${pageContext.request.contextPath}/BookList">
                Book List
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/CategoryList">
                Category List
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/PublisherList">
                Publisher List
            </a>
        </li>

    </ul>
</nav>