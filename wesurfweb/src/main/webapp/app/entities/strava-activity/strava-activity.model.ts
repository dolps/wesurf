import { BaseEntity } from './../../shared';

export class StravaActivity implements BaseEntity {
    constructor(
        public id?: number,
        public name?: string,
        public type?: string,
        public description?: string,
        public distance?: number,
        public date?: string,
    ) {
    }
}
