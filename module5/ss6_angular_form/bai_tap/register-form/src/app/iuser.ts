export interface IUser {
  userEmail?: string;
  pwGroup: {
    userPass?: string;
    useCPass?: string;
  },
  userAge?: number;
  userGender?: boolean;
  userPhone?: string;
}
