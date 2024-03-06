export class Todo {
    sno?: number;
    title: string;
    desc: string;
    active: boolean;

    constructor() {
        this.sno = undefined;
        this.title = '';
        this.desc = '';
        this.active = false;
    }
}