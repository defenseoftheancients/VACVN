let headers = new Headers();
headers.append("Access-Control-Allow-Origin", "*");
headers.append("Access-Control-Allow-Credentials", "true");
headers.append("Content-Type", "application/json");
headers.append("Accept-Encodinge", "gzip, deflate, br");
headers.append("Cache-Control", "no-cache");
headers.append("Accept", "*");
headers.append("Connection", "keep-alive");

export const fetchFunc = async (url) => {
    const response = await fetch(url);
    const data = response.json();
    return data;
};

export const getData = async (url) => {
    const response = await fetch(url, {
        method: "GET",
        mode: "cors",
        headers: headers,
    }).then(async (response) => {
        if (response.status === 200) {
            return response.json().then((data) => ({
                data: data,
                status: response.status,
            }));
        } else {
            return response;
        }
    });

    return response;
};
export const postData = async (url, json) => {
    const response = await fetch(url, {
        method: "POST",
        mode: "cors",
        headers: headers,
        body: json,
    }).then(async (response) => {
        if (response.status === 200) {
            return response.json().then((data) => ({
                data: data,
                status: response.status,
            }));
        } else {
            return response;
        } 
       
    })

    return response;
}
