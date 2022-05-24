export const formatDate = (inputDate, inputFormat, outputFormat) => {
    const splitDate = inputDate.split(inputFormat);
    console.log(inputFormat);
    if (inputFormat === "-") return splitDate.reverse().join(outputFormat);
    return splitDate.reverse().join(outputFormat);
  };
  