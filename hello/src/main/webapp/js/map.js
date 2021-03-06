function initMap() {
							var directionsService = new google.maps.DirectionsService;
							var directionsDisplay = new google.maps.DirectionsRenderer;
							var map = new google.maps.Map(document
									.getElementById('map'), {
								zoom : 10,
								center : {
									lat : 46.767307,
									lng : 23.603637
								}
							});
							directionsDisplay.setMap(map);

							var onChangeHandler = function() {
								calculateAndDisplayRoute(directionsService,
										directionsDisplay);
							};
							document.getElementById('start').addEventListener(
									'change', onChangeHandler);
							document.getElementById('end').addEventListener(
									'change', onChangeHandler);
						}

						function calculateAndDisplayRoute(directionsService,
								directionsDisplay) {
							directionsService.route(
											{
												origin : document
														.getElementById('start').options[document.getElementById('start').selectedIndex].text,
												destination : document
														.getElementById('end').options[document.getElementById('end').selectedIndex].text,
												travelMode : google.maps.TravelMode.DRIVING
											},
											function(response, status) {
												if (status === google.maps.DirectionsStatus.OK) {
													directionsDisplay
															.setDirections(response);
												} else {
													window
															.alert('Directions request failed due to '
																	+ status);
												}
											});
						}