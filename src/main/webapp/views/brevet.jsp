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
<a href="<%= request.getContextPath() %>/add-brevet" class="btn btn-primary mb-4">Add brevet</a>
</div>

<div class="border rounded-3 p-4">
	<table class="table mt-2 table-striped  table-hover"  id="dtBasicExample">
		<thead class=" table-dark ">
			<th>NUM_BREVET</th>
			<th>DESCRIPTION</th>
			<th>DATE_DEPOT</th>
			<th>DATE_VALIDATION</th>
			<th>NOM_INVENTEUR</th>	
			<th>INVENTION DESCRIPTIF</th>	
			<th class="text-center">Actions</th>	
		</thead>
		<tbody>
			<c:forEach var="item" items="${list }">
				<tr>
					<td>${item.num }</td>
					<td>${item.description }</td>
					<td>${item.dateDepot }</td>
					<td>${item.dateValidation }</td>
					<td>${item.inventeur.nom } ${item.inventeur.prenom }</td>
					<td>${item.invention.descriptif }</td>
					<td class="text-center" style="min-width: 140px;"> 
						<a class="btn btn-secondary" href="<%= request.getContextPath() %>/edit-brevet?num=${item.num}">Edit</a>
						<a class="btn btn-danger" href="<%= request.getContextPath() %>/delete-brevet?num=${item.num}">Delete</a>
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