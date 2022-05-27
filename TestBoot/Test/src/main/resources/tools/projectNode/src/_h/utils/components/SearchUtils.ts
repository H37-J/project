import { getAttributeValueByBreakpoint } from '../DomUtils'
import {
    DataUtils,

} from '../index'


export interface ISearchOptions {
    minLength: number
    keypress: boolean
    enter: boolean
    layout: 'menu' | 'inline'
    responsive?: number
    showOnFocues: boolean
}

export interface ISearchQueries {
    componentName: string
    instanseQuery: string
    attrQuery: string
}

const defaultSearchOptions: ISearchOptions = {
    minLength: 2, 
    keypress: true, 
    enter: true, 
    layout: 'menu', 
    showOnFocues: true, 
}
  
const defaultSearchQueires: ISearchQueries = {
    componentName: 'search',
    instanseQuery: '[data-h-search]',
    attrQuery: 'data-h-search-',
}

class SearchComponent {
    element: HTMLElement
    contentElement: HTMLElement
    formElement: HTMLFormElement
    inputElement: HTMLInputElement
    spinnerElement: HTMLElement
    clearElement: HTMLElement
    toggleElement: HTMLElement
    submitElement: HTMLElement
    toolbarElement: HTMLElement
    resultsElement: HTMLElement
    suggestionElement: HTMLElement
    emptyElement: HTMLElement
    layout: any

    options: ISearchOptions
    queries: ISearchQueries
  
    processing: boolean = false


    constructor(_element: HTMLElement, _options: ISearchOptions, _queries: ISearchQueries) {
        this.options = Object.assign(defaultSearchOptions, _options)
        this.queries = _queries
        this.element = _element
        this.contentElement = this._getElement('content') as HTMLElement
        this.formElement = this._getElement('form') as HTMLFormElement
        this.inputElement = this._getElement('input') as HTMLInputElement
        this.spinnerElement = this._getElement('spinner') as HTMLElement
        this.clearElement = this._getElement('clear') as HTMLElement
        this.toggleElement = this._getElement('toggle') as HTMLElement
        this.submitElement = this._getElement('submit') as HTMLElement
        this.toolbarElement = this._getElement('toolbar') as HTMLElement
    
        this.resultsElement = this._getElement('results') as HTMLElement
        this.suggestionElement = this._getElement('suggestion') as HTMLElement
        this.emptyElement = this._getElement('empty') as HTMLElement

        this.layout = this.getOption
    }   

    private _getElement = (name: string) => {
        return this.element.querySelector('[data-h-search-element="' + name + '"]');
    }

    private getOption = (name: string) => {
        const attr = this.element.getAttribute(`${this.queries.attrQuery}${name}`)
        if(attr) {
            let value = getAttributeValueByBreakpoint(attr)


        }
    }
}