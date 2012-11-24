<form METHOD="POST" ACTION="">
	<table>
			<tr>
			<td>Title</td>
			<td><input name="title" value=""></td>
		</tr>
		<tr>
			<td>Brand</td>
			<td><select name="brand" value=""></td>
		</tr>
		<tr>
			<td>Model</td>
			<td><select name="model" value=""></td>
		</tr>
		<tr>
			<td>Engine</td>
			<td><select name="engine" value=""></td>
		</tr>
		<tr>
			<td>Price<input name="priceFrom" value="" size="6" maxlength="6">-
			</td>
			<td><input name="priceTo" value="" size="6" maxlength="6"></td>
		</tr>
		<tr><td>Mileage<input name="mileageFrom" value="" size="6" maxlength="6">-</td>
					<td><input name="mileageTo" value="" size="6" maxlength="6"></td>
				</tr>
		<tr>
			<td>Year:<input name="yearFrom" value="" size="6" maxlength="4">-
			</td>
			<td><input name="yearTo" value="" size="6" maxlength="4"></td>
		</tr>

		<tr>
			<td>Color</td>
			<td><select name="color" value=""></td>
		</tr>
	</table>
	<input type="submit" value="Search">
</form>