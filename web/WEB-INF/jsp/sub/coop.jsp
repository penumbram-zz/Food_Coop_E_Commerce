<div>
	<h1>News Feed</h1>
	<div>
		<table class="table table-hover">
			<thead>
			<tr>
				<th>Event</th>
				<th>Description</th>
				<th>Photo</th>
			</tr>
			</thead>
			<tbody>
			<tr ng-repeat="n in nCtrl.newsList">
				<td><span ng-bind="n.name"></span></td>
				<td><span ng-bind="n.description"></span></td>
				<td><img style="height:100px; width:auto;" ng-src="{{n.photoUrl}}"></td>
			</tr>
			</tbody>
		</table>
	</div>
</div>