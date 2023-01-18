import { Task } from "./task";

export class Person {
    id:number|undefined;
    name: string | undefined;
    password:string | undefined;
    email: string | undefined;
    gender: string | undefined;
    work : Task[] = [];
    
    constructor(){ }
}       
