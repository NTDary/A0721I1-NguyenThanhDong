import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {SinhVienModel} from '../models/sinhVienModel';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ComponentService {
  API_URL = 'http://localhost:3000/students';

  constructor(private httpClient: HttpClient) {
  }

  getList(): Observable<SinhVienModel[]> {
    return this.httpClient.get<SinhVienModel[]>(this.API_URL);
  }

  findById(id: number): Observable<SinhVienModel> {
    return this.httpClient.get<SinhVienModel>(this.API_URL + '/' + id);
  }

  updateStudent(nhanVienModel: SinhVienModel): Observable<void> {
    console.log(nhanVienModel);
    return this.httpClient.patch<void>(this.API_URL + '/' + nhanVienModel.id, nhanVienModel);
  }

  deleteStudent(id: string): Observable<void> {
    return this.httpClient.delete<void>(this.API_URL + '/' + id);
  }

}
