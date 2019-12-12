Rails.application.routes.draw do
  get '/users/login', to: 'users#login'
  get '/', to: 'users#login'
  # For details on the DSL available within this file, see https://guides.rubyonrails.org/routing.html
end
