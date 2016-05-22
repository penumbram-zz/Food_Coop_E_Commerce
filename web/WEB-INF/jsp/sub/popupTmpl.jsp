<style type="text/css">
	td
	{
		padding:0 15px 0 15px;
	}
</style>

<div ng-model="ngDialogData">
	<div>
		<h3>Producer Information</h3>
		<table>
			<tr>
				<td>First Name:</td>
				<td ng-bind="ngDialogData.firstName"></td>
				<td rowspan="10"><img ng-src="{{ngDialogData.photoUrl}}" style="height: 5%;"></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td ng-bind="ngDialogData.lastName">
				</td>
			</tr>
			<tr>
				<td>E-mail:</td>
				<td ng-bind="ngDialogData.email">
				</td>
			</tr>
			<tr>
				<td>Address:</td>
				<td ng-bind="ngDialogData.addressLine1">
				</td>
			</tr>
			<tr>
				<td>City:</td>
				<td ng-bind="ngDialogData.city">
				</td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td ng-bind="ngDialogData.phone">
				</td>
			</tr>
			<tr>
				<td>About:</td>
				<td ng-bind="ngDialogData.about">
				</td>
			</tr>
			<tr>
				<td>Photo:</td>
				<td ng-bind="ngDialogData.photoUrl">
				</td>
			</tr>
			<tr>
				<td>Company:</td>
				<td ng-bind="ngDialogData.companyName">
				</td>
			</tr>
			<tr>
				<td>Farm Info:</td>
				<td ng-bind="ngDialogData.farmsInformation">
				</td>
			</tr>
		</table>
	</div>
</div>