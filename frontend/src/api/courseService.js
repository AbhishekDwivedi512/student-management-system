import axios from "axios";

const BASE_URL = "http://localhost:8080/auth/course";

export const registerCourse = (data) =>
  axios.post(`${BASE_URL}/register`, data);

export const updateCoursePrice = (id, data) =>
  axios.put(`${BASE_URL}/${id}/priceupdate`, data);

export const deleteCourse = (id) =>
  axios.delete(`${BASE_URL}/delete/${id}`);
