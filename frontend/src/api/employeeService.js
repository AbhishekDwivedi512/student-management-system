import axios from "axios";

const BASE_URL = "http://localhost:8080/api/auth/emp";

export const registerEmployee = (data) =>
  axios.post(`${BASE_URL}/registerEmployee`, data);

export const loginEmployee = (data) =>
  axios.post(`${BASE_URL}/loginEmployee`, data);

export const deleteEmployee = (id) =>
  axios.delete(`${BASE_URL}/delete/${id}`);
