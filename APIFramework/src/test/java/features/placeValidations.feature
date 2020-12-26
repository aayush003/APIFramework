Feature: Validating Place API's

@AddPlace @Regression
Scenario Outline: Verify if Place is being Successfully added using AddPlaceAPI
Given Add Place Payload with "<name>" "<language>" "<adderss>"
When user calls "AddPalceAPI" with "POST" http request
Then the API call got success with status code 200
And "status" in response body is "OK"
And verify place_Id created maps to "<name>" using "GetPlaceAPI"

Examples:
	|name	    | language  | address   |
	|AbcHouse   | English	| seelampur |
	|Saket house| French	| Saket     |

@DeletePlace @Regression
Scenario: Verify if Delete Place functionality is working
Given DeletePlace Payload
When user calls "DeletePlaceAPI" with "POST" http request
Then the API call got success with status code 200
And "status" in response body is "OK"