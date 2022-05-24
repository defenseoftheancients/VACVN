import { fetchFunc } from "../util/JsonUtil.js";

export let dataGeo = null;
fetchFunc(
  `https://raw.githubusercontent.com/daohoangson/dvhcvn/master/data/dvhcvn.json`
).then((res) => {
  dataGeo = res.data;
  console.log(dataGeo);
});

