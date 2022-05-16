import {Injectable} from '@angular/core';
import {Category} from "../model/category";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CategoryServiceService {
  private API_URL = "http://localhost:3000/categorys";

  constructor(private _httpClient: HttpClient) {
  }

  getAll(): Observable<Category[]> {
    return this._httpClient.get<Category[]>(this.API_URL);
  }

  saveCategory(category): Observable<Category> {
    return this._httpClient.post<Category>(this.API_URL, category);
  }

  findById(id: number): Observable<Category> {
    return this._httpClient.get<Category>(this.API_URL + '/' + id);
  }

  updateCategory(id: number, category: Category): Observable<Category> {
    return this._httpClient.put<Category>(this.API_URL + '/' + id, category);
  }

  deleteCategory(id: number): Observable<Category> {
    return this._httpClient.delete<Category>(this.API_URL + '/'+ id);
  }
}
