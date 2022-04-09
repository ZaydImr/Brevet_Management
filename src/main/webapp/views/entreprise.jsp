<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:if test="${message != null}">
	<div class="alert alert-success">
		${message}
	</div>
</c:if>

<c:if test="${messageErr != null}">
	<div class="alert alert-danger">
		${messageErr}
	</div>
</c:if>

<div class="w-100 text-end">
<a href="<%= request.getContextPath() %>/add-entreprise" class="btn btn-primary mb-4">Add entreprise</a>
</div>

<div class="border rounded-3 p-4">
	<table class="table mt-2 table-striped  table-hover"  id="dtBasicExample">
		<thead class=" table-dark ">
			<th>NUM_ENTREPRISE</th>
			<th>NOM_ENTREPRISE</th>
			<th>ACTIVITE</th>
			<th>CA</th>
			<th>VILLE</th>	
			<th class="text-center">Actions</th>	
		</thead>
		<tbody>
			<c:forEach var="item" items="${list }">
				<tr>
					<td>${item.num }</td>
					<td>${item.nom }</td>
					<td>${item.activite }</td>
					<td>${item.ca }</td>
					<td>${item.ville }</td>
					<td class="text-center"> 
						<a class="btn btn-secondary" href="<%= request.getContextPath() %>/edit-entreprise?num=${item.num}">Edit</a>
						<a class="btn btn-danger" href="<%= request.getContextPath() %>/delete-entreprise?num=${item.num}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap5.min.js"></script>
<script>
	$(document).ready(function () {
	  $('#dtBasicExample').DataTable();
	  $('.dataTables_length').addClass('bs-select');
	});
</script>