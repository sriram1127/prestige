<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title>Searchable Multi-select Dropdown Demos</title>
<link href="http://www.jqueryscript.net/css/jquerysctipttop.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="https://bootswatch.com/superhero/bootstrap.min.css">
<script type="text/javascript" src="./js/mock.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<link rel="stylesheet" type="text/css" href="./js/jquery.dropdown.css">
<script src="./js/jquery.dropdown.js"></script>
<style>
input[type=text], select, textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}

input[type=submit] {
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>

</head>

<body>
	<div>
		<img src="./image/MON-Logo.png" style="width: 300px; height: 60px;">
	</div>
	<br>
	<h3>Recognition Form</h3>

	<div class="container">
		<form action="Nominate" method="post">
			<label for="RegType">Recognition Type</label> <select id="regtype"
				name="regtype">
				<option value="Peer Recognition">Peer Recognition</option>
				<option value="Functional Recognition">Functional Recognition</option>
				<option value="Technology Recognition">Technology Recognition</option>
				<option value="Technology Recognition">Global breeding Excellance Award</option>
				<option value="Technology Recognition">High Level</option>
			</select> <label for="title">Title</label> <input type="text" id="title"
				name="title" placeholder="title.." maxlength="30" required>

			<label for="type">Award Type</label> <select id="type" name="type">
				<option value="GPS Monthly Recognition">Technology</option>
				<option value="Technology Recognition">Quarterly </option>
				<option value="GPS Monthly Recognition">Monthly </option>
			</select> <label for="area">Recognition Area</label> <select id="area"
				name="area">
				<option value="Choose Action">Choose Action</option>
				<option value="Learn Fast">Learn Fast</option>
				<option value="Win together techonology">Win together techonology</option>
				<option value="Hire & Develop the best">Hire & Develop the best</option>
				<option value="Imagine better solutions">Imagine better solutions</option>
			</select> <label for="nominee">Nominees</label>
			<div class="dropdown-mul-1">
				<select style="display: none" name="nominees" id="nominees" multiple
					placeholder="Select" required>
				</select>
			</div>

			<label for="Description">Description</label>
			<textarea id="Description" name="Description"
				placeholder="Write something.." style="height: 200px"
				maxlength="250" required></textarea>
			<input type="hidden" name="action" value="nominate"> <input
				type="submit" value="Submit" name="nominate" value="submit">
		</form>
	</div>

	<script>
		var Random = Mock.Random;
		var json1 = Mock.mock({
			"data|10-50" : [ {
				name : function() {
					return Random.name(true)
				},
				"id|+1" : 1,
				"disabled|1-2" : true,
				groupName : 'Group Name',
				"groupId|1-4" : 1,
				"selected" : false
			} ]
		});

		$('.dropdown-mul-1').dropdown({
			data : json1.data,
			limitCount : 40,
			multipleMode : 'label',
			choice : function() {
				// console.log(arguments,this);
			}
		});

		var json2 = Mock.mock({
			"data|10000-10000" : [ {
				name : function() {
					return Random.name(true)
				},
				"id|+1" : 1,
				"disabled" : false,
				groupName : 'Group Name',
				"groupId|1-4" : 1,
				"selected" : false
			} ]
		});

		$('.dropdown-mul-2').dropdown({
			limitCount : 5,
			searchable : false
		});

		$('.dropdown-sin-1').dropdown({
			readOnly : true,
			input : '<input type="text" maxLength="20" placeholder="Search">'
		});

		$('.dropdown-sin-2').dropdown({
			data : json2.data,
			input : '<input type="text" maxLength="20" placeholder="Search">'
		});
	</script>

</body>
<script type="text/javascript">
	var _gaq = _gaq || [];
	_gaq.push([ '_setAccount', 'UA-36251023-1' ]);
	_gaq.push([ '_setDomainName', 'jqueryscript.net' ]);
	_gaq.push([ '_trackPageview' ]);

	(function() {
		var ga = document.createElement('script');
		ga.type = 'text/javascript';
		ga.async = true;
		ga.src = ('https:' == document.location.protocol ? 'https://ssl'
				: 'http://www')
				+ '.google-analytics.com/ga.js';
		var s = document.getElementsByTagName('script')[0];
		s.parentNode.insertBefore(ga, s);
	})();
</script>

</html>