<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2/24/16
  Time: 1:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>user name</th>
        <th>operation</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>
                <a href="<spring:url value="/users/${user.id}" />">
                        <c:out value="${user.name}"/>
                </a>
            </td>
            <td>
                <a href="/users/remove/${user.id}" class="btn btn-danger triggerRemove">remove</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<!-- Modal -->
<div class="modal fade" id="modelRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Remove blog</h4>
            </div>
            <div class="modal-body">
                Really remove??
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">cancle</button>
                <a href="" class="btn btn-danger removeBtn">Remove</a>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

    $(document).ready(function () {
        $('.triggerRemove').click(function(e){
            e.preventDefault();
            $('#modelRemove .removeBtn').attr("href",$(this).attr("href"));
            $("#modelRemove").modal();
        });
    });
</script>