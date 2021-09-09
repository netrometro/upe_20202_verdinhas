import { Byte } from "@angular/compiler/src/util";

export interface Verdinha {
    id?: any;
    nome: String;
    especie: String;
    genero: String;
    nomePopular: String;
    dataAquisicao?: any;
    visivel: boolean;
    fotos: Byte;
    necessidades: any;
    local: any;
    caracteristicas: any;
}