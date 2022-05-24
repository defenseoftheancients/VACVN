
import { headers } from "../util/HeaderObject.js";
export const getUrlVars = () => {
	const vars = {};
	const parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi,
		function(m, key, value) {
			vars[key] = value;
		});
	return vars;
}
export const fetchFunc = async (url) => {
	const response = await fetch(url)
	const data = response.json();
	return data;
};
export const handleSubmit = async (e, url, method, json, successRedirectURL, falseRedirectURL) => {
	e.preventDefault();
	const response = await fetch(url,
		{
			method: method,
			mode: "cors",
			headers: headers,
			body: json
		}
	);
	response.json().then((data) => {
		console.log(data);
		if (data["id"] != null) {
			window.location.href = `${successRedirectURL}?id=${data["id"]}`;
		}
		else
			window.location.href = `${successRedirectURL}`;
	}).catch((error) => {
		console.error('Error:', error);
	});
}


