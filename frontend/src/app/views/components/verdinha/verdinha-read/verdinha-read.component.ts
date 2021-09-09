import { Verdinha } from './../../../../models/verdinha';
import { AfterViewInit, Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-verdinha-read',
  templateUrl: './verdinha-read.component.html',
  styleUrls: ['./verdinha-read.component.css']
})
export class VerdinhaReadComponent implements AfterViewInit {

  verdinhas: Verdinha[] = [];

  displayedColumns: string[] = ['id', 'nome', 'especie', 'genero', 'nomePopular', 
  'dataAquisicao' , 'visivel', 'fotos', 'necessidades', 'local', 'caracteristicas'];
  dataSource = new MatTableDataSource<Verdinha>(this.verdinhas);

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }
}
