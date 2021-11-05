<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <form:form method="post" modelAttribute="vartotojas">
        <c:if test="${vartotojas.id == null}">
            <p>Prideti nauja vartotoja:</p>
        </c:if>
        <div>
            <c:if test="${vartotojas.id != null}">
                <p>Atnaujinti vartotojas su id ${vartotojas.id}:</p>
            </c:if>
            <form:input path="id" type="hidden" required="required"/>
            <form:errors path="id"/>
        </div>
        <div>
            <form:label path="name">Vardas</form:label>
            <form:input path="name" type="text" required="required"/>
            <form:errors path="name"/>
        </div>
        <div>
            <form:label path="lastName">Pavarde</form:label>
            <form:input path="lastName" type="text" required="required"/>
            <form:errors path="lastName"/>
        </div>
        <div>
            <form:label path="telNr">Telefono numeris</form:label>
            <form:input path="telNr" type="text" required="required"/>
            <form:errors path="telNr"/>
        </div>
        <div>
            <form:label path="email">El. pasto adresas</form:label>
            <form:input path="email" type="text" required="required"/>
            <form:errors path="email"/>
        </div>
        <div>
            <form:label path="address">Adresas</form:label>
            <form:input path="address" type="text" required="required"/>
            <form:errors path="address"/>
        </div>
        <div>
            <form:label path="password">Slaptazodis</form:label>
            <form:input path="password" type="password" required="required"/>
            <form:errors path="password"/>
        </div>
        <button type="submit">OK</button>
    </form:form>
    <c:if test="${errorMessage != null}">
        <div>
            ${errorMessage}
        </div>
    </c:if>
</div>

<%@ include file="common/footer.jspf" %>