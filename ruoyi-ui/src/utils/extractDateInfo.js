export function extractDateInfo(dateTimeString) {
  const dateTime = new Date(dateTimeString);
  const year = dateTime.getFullYear();
  const month = (dateTime.getMonth() + 1).toString().padStart(2, '0'); // 月份补零
  const day = dateTime.getDate().toString().padStart(2, '0'); // 天数补零
  return `${year}-${month}-${day}`;
}
