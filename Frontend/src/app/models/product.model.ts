export interface Product {
  id?: number;
  name: string;
  description: string;
  qt: number;
  price: number;
  category: Category;
  fileName?: string | null;
    fileData?: any | null; 
}

export enum Category {
  Kids = 'Kids',
  Home = 'Home',
  Women = 'Women',
  Clothes = 'Clothes',
  Men = 'Men',
  Sport = 'Sport',
  Electric = 'Electric',
  Jewelry = 'Jewelry',
}
