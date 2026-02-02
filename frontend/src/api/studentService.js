import axios from "axios";

const BASE_URL = "http://localhost:8080/api/auth";

export const registerStudent = (data) =>
  axios.post(`${BASE_URL}/register`, data);

export const loginStudent = (data) =>
  axios.post(`${BASE_URL}/login`, data);

export const getAllStudents = () =>
  axios.get(`${BASE_URL}/All`);

export const deleteStudent = (id) =>
  axios.delete(`${BASE_URL}/delete/${id}`);
