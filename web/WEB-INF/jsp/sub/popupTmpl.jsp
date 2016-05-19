<div ng-model="ngDialogData" style="z-index:5000;">
	<div>
		<h3>Producer Information</h3>
		<table>
			<tr>
				<td>First Name:</td>
				<td ng-bind="ngDialogData.firstName">
				</td>
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
	<div class="ngdialog-buttons">
		<button type="button" class="ngdialog-button ngdialog-button-secondary" ng-click="closeThisDialog(0)">Close</button>
	</div>
</div>