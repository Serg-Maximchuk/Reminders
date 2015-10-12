(function() {
	var count = 0;

	//generates a unique id
	function generateId() {
		return "reminder-" + count;//+new Date();    
	}
	//saves an item to localStorage
	var saveReminder = function(id, content) {
		localStorage.setItem(id, content);
	};

	//handler for input
	var handleInput = function() {
		$('#input-form').on('submit', function(event) {
			var input = $('#text'), value = input.val();
			event.preventDefault();
			if (value) { 
				var text = value;
				var id = generateId();
				createReminder(id, text);
				$.ajax({
								url : 'add',
								type : 'GET',
								dataType : 'json',
								contentType : 'application/json',
								mimeType : 'application/json',
								data : ({
									id : id,
									text : text
								})
							});
				input.val(''); 
			}
		});
	};

	var editReminder = function(id, text) {
		$('#text').focus();
		if (!text) {
			var confirmation = confirm('Delete this item?');
			if (confirmation) {
				removeReminder(id);
			}
		} else {
			$('#' + id).text('');
			$('#' + id).append($('<input />',
					{	"type" : "radio",
						"name" : "rem",
						"id"   : id,
						change  : function() {
							if ($(this).is(':checked')) {
								$('.buttons').show();
								var text = $('#' + id).text().trim();
								$('#text').val(text);
							} else {
								$('.buttons').hide();
							}
						}
					}
		));
		$('#' + id).append(text);
		$('#' + id).append('<br>');
		}
	};

	var deleteReminder = function(id) {
		localStorage.removeItem(id);
		var elem = $('input[type=radio][name=rem]');
		elem.prop('checked', true);
		$('#text').val($('#' + elem.attr('id')).text());
	};

	var removeReminder = function(id) {
		var item = $('#' + id );
		item.addClass('removed-item').one(
					'webkitAnimationEnd oanimationend msAnimationEnd animationend', 
					function(e) {
						$(this).remove();
					}
		);
		deleteReminder(id);
	};

	var createReminder = function(id, content) {
		$('.reminders').append($('<li />',
					{	"id"		: id,
						"class"	: 'new-item',
					}
		));
		$('#' + id).append($('<input />',
					{	"type" : "radio",
						"name" : "rem",
						"id"   : id,
						change  : function() {
							if ($(this).is(':checked')) {
								$('.buttons').show();
								var text = $('#' + id).text().trim();
								$('#text').val(text);
							} else {
								$('.buttons').hide();
							}
						}
					}
		));
		$('#' + id).append(content + '<br>');
		saveReminder(id, content);
		count++;
	};
	

	var loadReminders = function() {
		if (localStorage.length !== 0) {
			for (var key in localStorage) {
				var text = localStorage.getItem(key);
				if (key.indexOf('reminder') === 0) {
					createReminder(key, text);
				}
			}
		}
	};

	var addButtons = function() {
		$('.buttons').append($('<button />',
					{	"style" : "background: grey; border: 1px solid white; padding: 9px;",
						"class" : "icon-trash delete-button",
						"title"	: "Delete",
						click: function() {
							var elem = $('input[type=radio][name=rem]:checked');
							var id = elem.attr('id');
							var value = $('#' + id).text();
							removeReminder(id);
							$.ajax({
								url : 'delete',
								type : 'GET',
								dataType : 'json',
								contentType : 'application/json',
								mimeType : 'application/json',
								data : ({
									id : id,
									text : value
								})
							});
						}
					}
		));

		$('.buttons').append($('<button />',
					{	"style"	: "background: grey; border: 1px solid white; padding: 9px 8px;",
						"class"	: "icon-save save-button",
						"title"	: "Update",
						click: function() {
							var elem = $('input[type=radio][name=rem]:checked');
							var id = elem.attr('id');
							var text = $('#text').val();
							editReminder(id, text);
							$.ajax({
								url : 'update',
								type : 'GET',
								dataType : 'json',
								contentType : 'application/json',
								mimeType : 'application/json',
								data : ({
									id : id,
									text : text
								})
							});
						}
					}
		));
	};

	var ifChecked = function() {
		$('input[type=radio][name=rem]').change(function() {
			if ($(this).is(':checked')) {
				$('.buttons').show();
				var id = $(this).attr('id');
				var text = $('#' + id).text().trim();
				$('#text').val(text);
			} else {
				$('.buttons').hide();
			}
		});
		$('#text').focus();
	}
	
	var init = function() {
		addButtons();
		loadReminders();
		//ifChecked();
		$('#text').focus();
		handleInput();
	};

	//start all
	init();

})();
