<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2/24/16
  Time: 8:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>

<h1>${user.name}</h1>

<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    New Blog
</button>

<form:form commandName="blog" cssClass="form-horizontal">
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">New blog</h4>
            </div>
            <div class="modal-body">


                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">Name:</label>
                    <div class="col-sm-10">
                        <form:input path="name" cssClass="form-control"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="url" class="col-sm-2 control-label">URL:</label>
                    <div class="col-sm-10">
                        <form:input path="url" cssClass="form-control"/>
                    </div>
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <input type="submit" value="Save" class="btn btn-primary" />
            </div>
        </div>
    </div>
</div>
</form:form>

<c:forEach items="${user.blogs}" var="blog">
    <h1>${blog.name}</h1>
    <p>${blog.url}</p>

    <table class="table table-bordered table-hover table-striped">
        <thead>
        <tr>
            <th>Title</th>
            <th>Link</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${blog.items}" var="item">
            <tr>
                <td>${item.title}</td>
                <td>${item.link}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:forEach>